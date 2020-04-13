package com.wangwenjun.concurrency.chapter6;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupName {

	public static void main(String[] args) {
		ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();

		ThreadGroup group = new ThreadGroup("Custome_Group");

		log.info("group.getParent==currentGroup:{}", group.getParent() == currentGroup);

		ThreadGroup group2 = new ThreadGroup(group,"Group2");

		log.info("group2.getParent==group:{}", group2.getParent() ==group);


	}
}
