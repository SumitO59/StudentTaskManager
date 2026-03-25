import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int idCounter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Task Manager =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Complete");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask(sc);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    updateTask(sc);
                    break;
                case 4:
                    deleteTask(sc);
                    break;
                case 5:
                    markComplete(sc);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addTask(Scanner sc) {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();

        tasks.add(new Task(idCounter++, title));
        System.out.println("Task added!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    private static void updateTask(Scanner sc) {
        System.out.print("Enter task ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Task t : tasks) {
            if (t.getId() == id) {
                System.out.print("Enter new title: ");
                t.setTitle(sc.nextLine());
                System.out.println("Task updated!");
                return;
            }
        }

        System.out.println("Task not found!");
    }

    private static void deleteTask(Scanner sc) {
        System.out.print("Enter task ID to delete: ");
        int id = sc.nextInt();

        tasks.removeIf(t -> t.getId() == id);
        System.out.println("Task deleted!");
    }

    private static void markComplete(Scanner sc) {
        System.out.print("Enter task ID to mark complete: ");
        int id = sc.nextInt();

        for (Task t : tasks) {
            if (t.getId() == id) {
                t.markCompleted();
                System.out.println("Task marked as complete!");
                return;
            }
        }

        System.out.println("Task not found!");
    }
}