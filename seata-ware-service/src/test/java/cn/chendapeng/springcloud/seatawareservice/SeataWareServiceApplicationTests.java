package cn.chendapeng.springcloud.seatawareservice;

import cn.chendapeng.springcloud.seatawareservice.entity.Ware;
import cn.chendapeng.springcloud.seatawareservice.service.WareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeataWareServiceApplicationTests {

    @Autowired
    private WareService wareService;

    @Test
    void testWare() {
        Ware obj1 = wareService.getById(1);
        System.out.println(obj1);

        wareService.deductStock(10086L);

        Ware obj2 = wareService.getById(1);
        System.out.println(obj2);
    }

}
