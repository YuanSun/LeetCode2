package builderPattern;
/**
 * 
 * @author sunyuan
 * This program will test builder pattern which is discribed in "Effective Java" p.14, Chapter 2
 */
public class NutritionFacts {
	/**
	 * note that NutritionFacts is immutable, 
	 * and that all parameter default values are in a single location
	 */
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	public static class Builder {
		// Required parameter
		private int servingSize;
		private int servings;
		
		// Optional parameters - initialized to default values
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;
		
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val) {
			calories = val;
			return this;
		}
		
		public Builder carbohydrate(int val) {
			fat = val;
			return this;
		}
		
		public Builder sodium (int val) {
			sodium = val;
			return this;
		}
		
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}
	
	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nNutrition facts are: \n");
		sb.append("Serving Size is " + servingSize + "\n");
		sb.append("servings is " + servings + "\n");
		sb.append("Calories is " + calories + "\n");
		sb.append("fat is " + fat + "\n");
		sb.append("sodium is " + sodium + "\n");
		sb.append("carbohydrate is " + carbohydrate + "\n");
		
		String st = new String(sb.toString());
		return st;
	}
}