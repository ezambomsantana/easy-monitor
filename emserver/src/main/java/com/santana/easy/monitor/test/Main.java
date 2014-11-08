package com.santana.easy.monitor.test;

import com.santana.easy.monitor.esclient.ESClient;

public class Main {

	public static void main(String[] args) {
		
		ESClient c = new ESClient();
		c.putData("a", "a", "a");
		c.getLocalization("a");

	}

}
