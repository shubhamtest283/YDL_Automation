package overriding;

class contractemployee extends employeesalary{
	 int perdaysalary;
	 double workingdays;
	 
	 contractemployee(int perdaysalary, double workingdays){
		 this.perdaysalary = perdaysalary;
		 this.workingdays = workingdays;
	 }
double calculatesalary() {
	return perdaysalary*workingdays;
}
}