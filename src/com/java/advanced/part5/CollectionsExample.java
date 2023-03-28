package com.java.advanced.part5;

import java.util.Collection;
import java.util.Set;

// The Collection in Java is a framework that provides an architecture to store
// and manipulate the group of objects.
// Java Collections can achieve all the operations that you perform on a data
// such as searching, sorting, insertion, manipulation, and deletion.
// Java Collection means a single unit of objects. Java Collection framework provides
// many interfaces (Set, List, Queue, Deque) and classes (ArrayList, Vector, LinkedList,
// PriorityQueue, HashSet, LinkedHashSet, TreeSet).
public class CollectionsExample {
	// Collections with Set interface
	public static void main(String[] args) {
		// Creating and displaying the set
		Collection<String> clubs = Set.of("Internazionale", "Benfica", "Napoli", "Real Madrid", "Bayern Munich", "Manchester City");
		System.out.println(clubs);
	}
}
