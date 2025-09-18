package com.foodDelivery.OrderManagement;

public class DeliveryAgent {
	private int agentId;
	private String agentName;
	private String agentPhone;
	public DeliveryAgent(int agentId, String agentName, String agentPhone) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.agentPhone = agentPhone;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentPhone() {
		return agentPhone;
	}
	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}
	
	
	
}
