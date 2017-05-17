package com.now.eai.scsp.model;

import org.springframework.data.gemfire.mapping.Region;
		
	//@Region("dealer")
	public class Dealers {
			//@Id
			private String id;
			private String dealerName;
			private String address;
			private String city;
			private String state;
			private String zipcode;
			
			/*@PersistenceConstructor
			public Dealers(String id, String dealerName, String address, String city, String state, String zipcode) {
			        this.id = id;
			        this.dealerName = dealerName;
			        this.address = address;
			        this.city = city;
			        this.state = state;
			        this.zipcode = zipcode;
			}
			*/
		
			public String getDealerName() {
				return dealerName;
			}


			public void setDealerName(String dealerName) {
				this.dealerName = dealerName.trim();
			}
			public String getId() {
				return id;
			}


			public void setId(String id) {
				this.id = id.trim();
			}

			public String getAddress() {
				return address;
			}


			public void setAddress(String address) {
				this.address = address.trim();
			}

			public String getCity() {
				return city;
			}


			public void setCity(String city) {
				this.city = city.trim();
			}

			public String getState() {
				return state;
			}


			public void setState(String state) {
				this.state = state.trim();
			}

			public String getZipcode() {
				return zipcode;
			}


			public void setZipcode(String zipcode) {
				this.zipcode = zipcode.trim();
			}
			
			
			

		}




