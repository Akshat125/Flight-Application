package hello.world.demo;

import controller.HelloControllerDEMO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloControllerDEMO.class)
@ContextConfiguration(classes = HelloControllerDEMO.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSayHello() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/sayHello/");
        String result = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        assertEquals("Hello World!", result);
    }

}
