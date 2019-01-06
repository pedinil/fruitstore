package com.cybercom;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cybercom.model.Fruit;
import com.cybercom.rest.controller.RestFruitController;
import com.cybercom.services.FruitService;


/**
 * Java unit test for rest controller 
 * @author pedram
 * @version 0.1.0
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = RestFruitController.class, secure = false)
public class RestFruitsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FruitService fruitsService;

    
    /**
     * it will test the {@link RestFruitController} getFruit with path /fruitstores/getfruits 
     * @throws Exception
     */
    @Test
    public void getFruit() throws Exception {

	Fruit mockFruit = new Fruit("apple", "red", 21d);
	String expected = "{\"fruitName\":\"apple\",\"fruitType\":\"red\",\"price\":\"21\"}";
	when(fruitsService.findByFruitId(Mockito.anyLong())).thenReturn(mockFruit);

	MvcResult mvcResult = mockMvc
		.perform(MockMvcRequestBuilders.get("/fruitstores/getfruits/1").accept(MediaType.APPLICATION_JSON))
		.andReturn();

	JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(),false);
    }
    
    
    /**
     * it will test the {@link RestFruitController} saveFruit with path /fruitstores/save/fruit
     * @throws Exception
     */
    @Test
    public void saveFruit() throws Exception {

	Fruit mockFruit = new Fruit("apple", "yellow", 21d);

	String exampleFruitJson = "{\"fruitName\":\"apple\",\"fruitType\":\"yellow\",\"price\":\"21\"}";

	when(fruitsService.saveFruit(Mockito.any(Fruit.class))).thenReturn(mockFruit);

	MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/fruitstores/save/fruit")
		.accept(MediaType.APPLICATION_JSON).content(exampleFruitJson).contentType(MediaType.APPLICATION_JSON))
		.andReturn();
	MockHttpServletResponse response = mvcResult.getResponse();
	Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());

	
    }

    /**
     * it will test the {@link RestFruitController} fruitList with path /fruitstores/fruit
     * @throws Exception
     */
    @Test
    public void fruitList() throws Exception {
	when(fruitsService.listFruit()).thenReturn(Collections.emptyList());

	MvcResult mvcResult = mockMvc
		.perform(MockMvcRequestBuilders.get("/fruitstores/fruit").accept(MediaType.APPLICATION_JSON))
		.andReturn();

	verify(fruitsService).listFruit();
    }

  


}
