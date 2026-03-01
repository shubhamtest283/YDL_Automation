package overriding;

class permenantemplyee extends employeesalary {
	int basicsalary;
	int bonus;
	
	 permenantemplyee(int basicsalary, int bonus) {
	 this.basicsalary=basicsalary;
	 this.bonus= bonus;
}
	 double calculatesalary() {
		 return basicsalary+bonus;
	 }
}