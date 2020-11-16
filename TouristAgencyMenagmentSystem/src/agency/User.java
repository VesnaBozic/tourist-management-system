package agency;

public abstract class User {
		private String name;
		private String surname;
		private String userName;
		private String code;
		
		public User() {}

		public User(String name, String surname, String userName, String code) {
			super();
			this.name = name;
			this.surname = surname;
			this.userName = userName;
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((code == null) ? 0 : code.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((surname == null) ? 0 : surname.hashCode());
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof User)) {
				return false;
			}
			User other = (User) obj;
			if (code == null) {
				if (other.code != null) {
					return false;
				}
			} else if (!code.equals(other.code)) {
				return false;
			}
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			if (surname == null) {
				if (other.surname != null) {
					return false;
				}
			} else if (!surname.equals(other.surname)) {
				return false;
			}
			if (userName == null) {
				if (other.userName != null) {
					return false;
				}
			} else if (!userName.equals(other.userName)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return name + "," + surname;
		}

		
		

}
