package schuljahr2;

import java.util.Arrays;

public class BubbleSortAufgabe {

	static int paketnummer[] = {9,7,5,3,1,10,8,6,4,2};

	public static void main(String[] args) {
		System.out.println("Unsortiert:");
		System.out.println(Arrays.toString(paketnummer) + "\n");

		System.out.println("Nicht optimiert:");
		unoptimizedBubbleSort(paketnummer);
		System.out.println("\nOptimiert:");
		optimizedBubbleSort(paketnummer);
	}
	
	public static void unoptimizedBubbleSort(int[] list) {
		int count = 0;
		
		for(int i = 0; i < list.length - 1; i++) {
			for(int j = 0; j < list.length - 1; j++){
				if(list[j] > list[j+1])
				{
					int zwischenspeicher = list[j];
					list[j] = list[j+1];
					list[j+1] = zwischenspeicher;
				}
				count++;
			}
		}
		
		System.out.println(Arrays.toString(list));
		System.out.println("Vergleiche: " + count);
	}
	
	public static void optimizedBubbleSort(int[] list) {
		int count = 0;
		
		for(int i = 0; i < list.length - 1; i++) {
			for(int j = 0; j < list.length - 1 - i; j++){
				if(list[j] > list[j+1])
				{
					int zwischenspeicher = list[j];
					list[j] = list[j+1];
					list[j+1] = zwischenspeicher;
				}
				count++;
			}
		}
		
		System.out.println(Arrays.toString(list));
		System.out.println("Vergleiche: " + count);
	}
}
