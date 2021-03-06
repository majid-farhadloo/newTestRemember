import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CarTest {
	//instance of our array to be used to store our car objects
	static Car[] carArray = new Car[722];

	public static void main(String[] args) {
		//create a variable of type Student
		//Car car1  = new Car();
		//System.out.println(car1);
		//System.out.println(car1.getMpg());
		//System.out.println(car1.getModelOfCar());
		// See if the file is present, catch exception if not
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File("carMPG.txt"));
		} 
		catch (FileNotFoundException e) {

			System.out.println("Error opening the file carMPG.txt");
			System.exit(40);
		}
		int index = 0;
		while(inputStream.hasNext()){
			double newMpg = inputStream.nextDouble();
			String newString = inputStream.nextLine();
			Car newCar = new Car (newMpg, newString);
			//System.out.println(newCar);
			carArray[index++] = newCar;
		}
		//print out the array
		for(int i =0; i<carArray.length;i++){
		//System.out.println(carArray[i]);
		}
		/*for (Car car: carArray){
			//System.out.println(car);
		}*/
		System.out.println(" the min mpg is :" + findMin() + "\n" + " the max min mpg is : " + findMax() + "\n the average is " + findAvg() + "\n the standard deviation" + findStdDev());
	}
	// method to find the min mpg in our list

	public static double findMin(){
		double minMpg = carArray[0].getMpg();
		for(int i =0; i<carArray.length;i++){
		//for (Car i : carArray){
			if(carArray[i].getMpg()< minMpg){
			//if(i.getMpg()< minMpg){	
				//minMpg= i.getMpg();	
				minMpg= carArray[i].getMpg();
			}
		}
		return minMpg;
	}
	//static double sum = 0;
	public static double findMax()  {
		double maxMpg = carArray[0].getMpg();
		for(int i =0; i<carArray.length;i++){
			if(carArray[i].getMpg() > maxMpg){
				maxMpg= carArray[i].getMpg();
			}
		}
		return maxMpg;
	}
	public static double findAvg(){
		double sum = 0;
		int i = 0;
		for(i = 0; i<carArray.length;i++){
			sum += carArray[i].getMpg();		
		}
		double avg = sum/i;
		return avg;
	}
	public static double findVariance(){
		double average = findAvg();
		double diffSq = 0;
		for(int i =0; i<carArray.length;i++){
			diffSq += Math.pow((carArray[i].getMpg() - average),2); 
		}
		return (diffSq/carArray.length);
	}
	public static double findStdDev(){
		double stdDev = Math.pow(findVariance(),0.5);
		return stdDev;
	}		
}


/*Car car2 = new Car("Mary", 34, 5);
		System.out.println(car2);
		System.out.println(car2.getMpg());
		System.out.println(car2.getModelOfCar());

		car1 = car2;
		System.out.println(car1);
		System.out.println(car1.getName());
		System.out.println(car1.getAge());

		car1.setName("lisa");
		System.out.println(car2.getName());
		if(car1.equals(car2))
			System.out.println(" The students are the same");
		else
			System.out.println(" the students are not the same"); 
	}

}*/

