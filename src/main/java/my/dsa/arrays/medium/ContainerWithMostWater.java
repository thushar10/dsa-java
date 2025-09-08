package my.dsa.arrays.medium;

public class ContainerWithMostWater {

  public static void main(String[] args) {

    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    int maxArea = containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    System.out.println(maxArea);
  }


  public int maxAreaOn2(int[] height) {

    int maxArea = 0;
    for(int i = 0; i< height.length; i++) {

      for(int j =i; j< height.length; j++) {

        int minHeight = Math.min(height[i], height[j]);
        int width = j-i;
        maxArea = Math.max(maxArea, width * minHeight);
      }
    }
    return maxArea;
  }

  public int maxArea(int[] height) {

    int maxArea = 0;
    int l =0;
    int r= height.length -1;
    while(r >= l) {

      int width = r - l;
      int minHeight = Math.min(height[l], height[r]);
      maxArea = Math.max(maxArea, width * minHeight);
      if(height[l] > height[r]) {
        r--;
      }else if (height[l] < height[r]) {
        l++;
      }else {
        r--;
      }


    }


    return maxArea;
  }

}
