import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Run {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("AlphaBook-Production");
            System.out.println("Bảng đã được tạo tự động dựa trên cấu hình trong persistence.xml");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close(); // Đóng EntityManagerFactory
            }
        }
    }
}
