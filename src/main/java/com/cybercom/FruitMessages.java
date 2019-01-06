package com.cybercom;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cybercom.config.MqttConfig;
import com.cybercom.model.Fruit;
import com.cybercom.services.FruitService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * this class connect to broker and once the message received saved it to DB
 * 
 * @author pedram
 * @version 0.5.0
 * @since Jan 1 2019
 */

@Slf4j
@Component
public class FruitMessages implements MqttCallback {

    @Autowired
    private FruitService fruitsService;

    /**
     * 
     * @param mqttConfig
     *            it object contain mqtt config which can be use in initial
     *            setting
     * @throws MqttException
     */
    @Autowired
    public FruitMessages(MqttConfig mqttConfig) throws MqttException {

	//
	String publisherId = UUID.randomUUID().toString();
	MqttClient mqttClient = new MqttClient(mqttConfig.getConnectionUrl(), publisherId);

	// Authentication
	MqttConnectOptions connOpts = new MqttConnectOptions();
	connOpts.setCleanSession(true);
	connOpts.setAutomaticReconnect(true);
	connOpts.setUserName(mqttConfig.getUsername());
	connOpts.setPassword(mqttConfig.getPassword().toCharArray());

	// MqttCallback
	mqttClient.setCallback(this);
	mqttClient.connect(connOpts);
	mqttClient.subscribe("new/fruit");

    }

    @Override
    public void connectionLost(Throwable cause) {
	log.info("Connection lost");
    }

    // mosquitto_pub -h 127.0.0.1 -m
    // {\"fruitType\":\"test\",\"fruitName\":\"tets2\"}. -t new/fruit

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
	// would be nice to save the fruits..

	String strMessage = new String(message.getPayload());
	log.info("broker message : ", strMessage);

	ObjectMapper mapper = new ObjectMapper();
	Fruit fruit = mapper.readValue(strMessage, Fruit.class);
	fruitsService.saveFruit(fruit);

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }
}
