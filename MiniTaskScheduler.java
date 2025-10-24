import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private String deadline;

    public Task(String title, String description, String deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        String taskInfo = "📌 " + title;
        if (!description.isEmpty()) taskInfo += " | 📝 " + description;
        if (!deadline.isEmpty()) taskInfo += " | ⏰ " + deadline;
        return taskInfo;
    }
}

public class MiniTaskScheduler {

    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🗓️ Welcome to Mini Task Scheduler!");
        System.out.println("Organize your daily tasks easily using this console app.\n");

        boolean running = true;
        while (running) {
            System.out.println("\n==================== MENU ====================");
            System.out.println("1️⃣  Add a New Task");
            System.out.println("2️⃣  View All Tasks");
            System.out.println("3️⃣  Delete a Task");
            System.out.println("4️⃣  Exit");
            System.out.println("==============================================");
            System.out.print("👉 Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    deleteTask();
                    break;
                case "4":
                    running = false;
                    System.out.println("✅ Exiting Mini Task Scheduler. Have a productive day! 🌟");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }

    // Method to add a new task
    private static void addTask() {
        System.out.print("\nEnter Task Title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter Task Description (optional): ");
        String description = scanner.nextLine().trim();

        System.out.print("Enter Task Deadline or Time (optional): ");
        String deadline = scanner.nextLine().trim();

        Task newTask = new Task(title, description, deadline);
        tasks.add(newTask);
        System.out.println("✅ Task added successfully!");
    }

    // Method to view all tasks
    private static void viewTasks() {
        System.out.println("\n==================== YOUR TASKS ====================");
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks available. Start adding some!");
        } else {
            int i = 1;
            for (Task task : tasks) {
                System.out.println(i + ". " + task);
                i++;
            }
        }
        System.out.println("====================================================");
    }

    // Method to delete a task
    private static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("\n⚠️ No tasks to delete!");
            return;
        }

        viewTasks();
        System.out.print("\nEnter the task number to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            if (index > 0 && index <= tasks.size()) {
                System.out.print("❓ Are you sure you want to delete this task? (y/n): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    tasks.remove(index - 1);
                    System.out.println("🗑️ Task deleted successfully!");
                } else {
                    System.out.println("❎ Task deletion canceled.");
                }
            } else {
                System.out.println("⚠️ Invalid task number!");
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Please enter a valid number!");
        }
    }
}
