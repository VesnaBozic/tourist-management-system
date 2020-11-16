package agency;

import java.util.Collection;

public class TravelAgency {
	private String agencyName;
	private Collection<Client> client;
	private Collection<Agent> agent;
	
	public TravelAgency() {}

	public TravelAgency(String agencyName, Collection<Client> client, Collection<Agent> agent) {
		super();
		this.agencyName = agencyName;
		this.client = client;
		this.agent = agent;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Collection<Client> getClient() {
		return client;
	}

	public void setClient(Collection<Client> client) {
		this.client = client;
	}

	public Collection<Agent> getAgent() {
		return agent;
	}

	public void setAgent(Collection<Agent> agent) {
		this.agent = agent;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TravelAgency)) {
			return false;
		}
		TravelAgency other = (TravelAgency) obj;
		if (agencyName == null) {
			if (other.agencyName != null) {
				return false;
			}
		} else if (!agencyName.equals(other.agencyName)) {
			return false;
		}
		if (agent == null) {
			if (other.agent != null) {
				return false;
			}
		} else if (!agent.equals(other.agent)) {
			return false;
		}
		if (client == null) {
			if (other.client != null) {
				return false;
			}
		} else if (!client.equals(other.client)) {
			return false;
		}
		return true;
	}

	
	public String toString() {
		return "TravelAgency [agencyName=" + agencyName + ", client=" + client + ", agent=" + agent + "]";
	}
	public String uCSV() {
		return   agencyName + "," + client +","+ agent  +"\n" ;
	}
}
 
