package com.wangwenjun.concurrency.chapter3.flight;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
public class FlightDemo {

	private static List<String> flightCompany = Arrays.asList("CSA", "CEA", "HNA");

	public static void main(String[] args) {

		List<String> result = search("SH", "BJ");
		log.info("=============================result============");
		result.forEach(log::info);
	}

	private static List<String> search(String original, String destination) {

		final List<String> result = new ArrayList<>();

		List<FlightQueryTask> tasks = flightCompany.stream()
				.map(f -> createTask(f, original, destination))
				.collect(toList());

		tasks.forEach(Thread::start);

		tasks.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		tasks.stream().map(FlightQueryTask::query).forEach(result::addAll);
		return result;
	}

	private static FlightQueryTask createTask(String f, String original, String destination) {

		return new FlightQueryTask(f, original, destination);
	}
}
