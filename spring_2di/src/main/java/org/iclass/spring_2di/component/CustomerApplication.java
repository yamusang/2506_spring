package org.iclass.spring_2di.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CustomerApplication {

    private final BuyConfig buyConfig;

    CustomerApplication(BuyConfig buyConfig) {
        this.buyConfig = buyConfig;
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CustomerApplication.class, args);
        log.info("////");
        log.info("-------------------------------");
        CustomerDao dao = context.getBean(CustomerDao.class); // 타입으로 bean 매칭(bean은 기본이 싱글톤)
        // CustomerDao dao2 = (CustomerDao)context.getBean("customerDao"); 이름으로 bean 매칭
        // 매칭
        dao.setGroups();
        CustomerService service = context.getBean(CustomerService.class);
        service.test();
        CustomerController controller = context.getBean(CustomerController.class);
        controller.test();
    }
}
