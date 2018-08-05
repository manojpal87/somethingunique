
package com.tiaa.problem.collectionValidatorEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.json.JSONArray;
import org.json.JSONObject;

import com.tiaa.problem.entity.CmfoodchainType;
import com.tiaa.problem.entity.OrderdetailType;

/**
 * 
 *
 */
public class ValidatorEngine {

	private List<CmfoodchainType> fileList = new ArrayList<CmfoodchainType>();

	public static void main(String[] args) throws JAXBException {
		ValidatorEngine engine = new ValidatorEngine();
		engine.validateAllCollection();
	}

	public void validateAllCollection() throws JAXBException {

		// load all files-
		File file = new File("E:/Software/new_workspace/CollectionValidatorEngine/src/main/resources/branchfile");
		File[] files = file.listFiles();
		for (File f : files) {
			System.out.println(f.getName());

			if (f.getName().contains("xml")) {
				parseXmlFile(file);
			} else {
				parseJsonFile(file);
			}
		}
		// cross checking amount
		crossCheckAmount();
	}

	@SuppressWarnings({ "unchecked" })
	private void parseXmlFile(File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		JAXBElement<CmfoodchainType> unmarshalledObject = (JAXBElement<CmfoodchainType>) unmarshaller.unmarshal(file);
		CmfoodchainType cmfoodchainType = unmarshalledObject.getValue();
		fileList.add(cmfoodchainType);
	}

	private void parseJsonFile(File file) {
        //TODO
	}

	private void crossCheckAmount() {
		if (!fileList.isEmpty()) {
			for (CmfoodchainType cmfoodchainType : fileList) {
				float totalCollection = cmfoodchainType.getBranch().getTotalcollection();
				float totalCalculatedAmount = getCalculatedTotalAmount(cmfoodchainType.getOrders().getOrderdetail());
				if (totalCollection != totalCalculatedAmount) {
					makeUnmatchEntry(cmfoodchainType, totalCalculatedAmount);
				} else {
					makeMatchEntry(cmfoodchainType, totalCalculatedAmount);
				}
			}
		}
	}

	private void makeUnmatchEntry(CmfoodchainType cmfoodchainType, float caculatedOrderAmount) {

		FileWriter fileWriter = null;
		try {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("cmfoodchain", "cmfoodchain");

			JSONArray branchList = new JSONArray();
			//branchList.put("location", cmfoodchainType.getBranch().getLocation());
			//branchList.put("totalcollection", cmfoodchainType.getBranch().getTotalcollection());
			//branchList.put("sumoforder", caculatedOrderAmount);

			jsonObj.put("branch", branchList);

			File file = new File("E:/Software/new_workspace/CollectionValidatorEngine/src/main/resources/MisMatch.json");
			fileWriter = new FileWriter(file);

			fileWriter.write(jsonObj.toString());

		} catch (Exception e) {
			System.err.println("Error while writing in mismatch file");
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.err.println("Error while writing in mismatch file");
			}

		}
	}

	private void makeMatchEntry(CmfoodchainType cmfoodchainType, float caculatedOrderAmount) {
     //TODO
	}

	private float getCalculatedTotalAmount(List<OrderdetailType> orderDetails) {

		float amount = 0;
		for (OrderdetailType type : orderDetails) {
			amount += type.getBillamount();
		}
		return amount;
	}

}
