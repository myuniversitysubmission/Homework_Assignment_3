# Homework_Assignment_3 Java Concurrency

📘 Introduction
This Assignment demonstrates how concurrency works in Java by simulating two real-world scenarios:
Multiple Automated Guided Vehicles (AGVs) trying to charge at a limited number of charging stations.
Several tasks being performed at the same time using a thread pool.
Through these simulations, the assignment explores how Java manages multiple operations simultaneously using threads, semaphores, and executors ensuring efficiency, safety, and responsiveness.

---

⚙️ Objectives
To understand and apply Java’s concurrency mechanisms.
To demonstrate resource sharing and synchronization using threads.
To implement parallel execution using the Executor framework.
To highlight how thread management improves performance and reduces waiting time.
Theoretical Answers: Java Concurrency

---

🧩 Key Concepts Used
1️⃣ Threads
A thread is the smallest unit of execution in Java.
It allows multiple operations to run concurrently.
In this assignment, each AGV or task runs as a separate thread, simulating independent actions happening at the same time.

2️⃣ Semaphores
A semaphore controls access to shared resources.
Here, it limits the number of AGVs that can charge simultaneously.
If all charging slots are occupied, other AGVs must wait — ensuring that no two AGVs use the same charging port at once.

3️⃣ ExecutorService
The ExecutorService manages a pool of threads efficiently.
Instead of creating a new thread for every task, it reuses existing ones improving performance and saving system resources.
It automatically assigns tasks to available threads.

4️⃣ Synchronization
Synchronization ensures that shared resources are accessed safely.
In the charging simulation, it prevents multiple AGVs from overusing the same station.
In the task simulation, it ensures tasks execute properly without interfering with each other.

---

🔋 Part 1: AGV Charging Simulation
In the charging simulation, multiple AGVs arrive at a station with only a few charging spots.
Each AGV runs as a separate thread and requests permission to charge.
A Semaphore controls how many AGVs can charge at a time — for example, only 3 out of 10 can charge simultaneously.
If no charging spot is available, the AGV waits. Once another AGV finishes and releases the spot, the waiting AGV gets its turn.
This demonstrates how thread synchronization and waiting work in concurrent environments.

Key Learning:
Demonstrates the concept of resource limitation and synchronized access.
Avoids race conditions and deadlocks using semaphores.
Mimics real-world scheduling problems.

---

⚙️ Part 2: Task Execution Simulation
The task simulation focuses on how multiple jobs can be handled efficiently using a fixed thread pool.
Instead of creating 8 new threads for 8 tasks, only 3 threads are created and reused.
As soon as one thread finishes its current task, it automatically takes up the next pending task.
This model reflects how real-world systems optimize performance — such as delivery robots, server requests, or background processes.
By reusing threads, the program saves time and avoids memory overhead.

Key Learning:
Demonstrates parallel task execution and thread reuse.
Shows the advantage of ExecutorService in managing concurrent workloads.
Reduces system load while maintaining efficiency.

---

🧠 Understanding the Output
When the program runs, you can see that multiple AGVs or tasks start and finish in mixed order.
This is because the CPU switches between threads, allowing many operations to progress simultaneously.

For example:
Task 1 started by Thread-1
Task 2 started by Thread-2
Task 3 started by Thread-3
Task 1 completed by Thread-1
Task 4 started by Thread-1

This random order of execution proves that the system is concurrent — not sequential.

---

📚 Concepts Demonstrated
Concurrency vs Parallelism – The program shows how multiple operations make progress at once (concurrency) and how threads can execute truly in parallel on multiple cores.
Resource Management – Limited resources (charging stations or threads) are shared among many requests safely.
Synchronization – Threads coordinate access to avoid conflicts and race conditions.
Thread Reuse – ExecutorService efficiently manages and reuses threads, saving system resources.

---

✅ Learning Outcomes
By completing this assignment, we learned:
How to create and manage threads in Java.
The role of semaphores in controlling concurrent access.
How thread pools improve efficiency and resource utilization.
The difference between concurrency and parallelism in practice.
How Java’s concurrency framework helps build scalable, responsive systems.

---

🧾 Conclusion
This assignment successfully simulates real-world concurrency scenarios using Java.
It demonstrates how multiple threads can work together efficiently while avoiding conflicts through synchronization and controlled resource access.
The AGV Charging and Task Execution simulations provide a clear understanding of how concurrency improves performance and responsiveness in software systems.

---
Code Output: 

<img width="1920" height="1080" alt="Screenshot (18)" src="https://github.com/user-attachments/assets/8e98a229-b961-4d21-9d3d-5eaec4a6f2ff" />


---

👨‍💻 Team Contribution

Adesh: Implemented AGV Charging simulation using threads and semaphores.

Dnyaneshwar: Developed Task Execution simulation using ExecutorService.

Harsha: Designed thread control, synchronization logic, and debugging.

Anil: Prepared documentation, explanations, and output analysis.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Theory Questions & Answers: 

1️⃣ Comparison of Concurrency Models
In software systems, concurrency models describe how multiple tasks run and communicate with each other at the same time.
The most common models are the thread-based, actor, and event-driven models.
The thread-based model is the traditional approach used in Java. In this model, several threads share the same memory space and communicate through shared variables. Synchronization tools such as the synchronized keyword, locks, and semaphores are used to manage access to shared resources. The main advantage of this model is that communication between threads is fast because data is shared directly in memory. However, it is also risky — if synchronization is not handled carefully, it can lead to race conditions, deadlocks, and inconsistent results. Debugging multi-threaded code can therefore be quite difficult.
The actor model takes a different approach. Here, every actor is an independent unit that has its own state and communicates only by sending and receiving messages. Actors do not share memory, which eliminates the risk of race conditions. This model is safer and easier to scale because multiple actors can run on different processors or machines. On the other hand, it is more complex to design, and message-passing introduces some delay or overhead in communication.
The event-driven model is commonly used in graphical user interfaces and server applications. In this model, the program reacts to events such as user input or data arrival from a network. Instead of blocking, the system waits for events and triggers the appropriate response through callbacks or listeners. This makes the program responsive and efficient, especially for I/O-bound tasks. However, it can become harder to maintain when the number of events grows, and the code can become difficult to read due to deeply nested callbacks.
In summary, the thread model is easy to start with but requires careful synchronization, the actor model provides safety and scalability, and the event-driven model offers high responsiveness but can be complex to organize.

2️⃣ Concurrency vs Parallelism
Although the words concurrency and parallelism are often used together, they describe different concepts.
Concurrency means that multiple tasks make progress during the same period, even if only one task runs at a given instant. The system switches between tasks so that each appears to be running simultaneously. It is mainly about managing multiple tasks efficiently.
Parallelism, on the other hand, means that tasks truly execute at the same time on multiple processors or CPU cores. It focuses on speed and performance rather than structure.
For example, if a single CPU alternates quickly between reading a file and writing logs, that is concurrency. If a computer with four cores performs four independent calculations at the same time, that is parallelism.
In short, concurrency is about dealing with many things at once, while parallelism is about doing many things at once. Java supports both through features like threads, executors, and parallel streams. Concurrency improves responsiveness, and parallelism improves processing speed.

3️⃣ Blocking and Non-Blocking Concurrency Algorithms
Concurrency in Java can also be divided into blocking and non-blocking approaches, which describe how threads behave when they need a shared resource.
In a blocking algorithm, a thread must wait until the resource it needs becomes available. Typical examples include synchronized blocks, the wait() and join() methods, or the use of explicit locks. The main benefit of blocking code is simplicity — it is easy to understand and reason about because one thread waits its turn. However, blocking threads waste CPU time while they are idle, and they can easily create bottlenecks or even deadlocks if several threads wait on each other.
A non-blocking algorithm allows threads to continue working without waiting. Instead of locking, it uses atomic operations such as compareAndSet() from the java.util.concurrent.atomic package. These algorithms continuously attempt to update shared data safely without stopping other threads. Non-blocking designs are faster, avoid deadlocks, and scale better under heavy load, but they are harder to design correctly and can use more CPU resources because threads may retry operations many times.
Overall, blocking algorithms are simpler but slower under heavy concurrency, while non-blocking algorithms provide high performance and safety at the cost of greater complexity.

---
Vide Explantion Link:
