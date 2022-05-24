class App {
  public static void main(String args[]) {
    App.setParameters("5/24/22", 5, true, true, true, 24);
  }

  public static void setParameters(String pickupDate, int rentalDays, boolean tollTag, boolean gps, boolean roadside,
      int age) {
    double grandTotal = basicRental(rentalDays) + underageSurcharge(age, rentalDays)
        + optionsLogic(rentalDays, tollTag, gps, roadside);
    System.out.println("Your grand total is: " + grandTotal);
    System.out.println("Breakdown of Costs");
    System.out.println("Basic Rental:" + basicRental(rentalDays));
    System.out.println("Under 25 Surcharge:" + underageSurcharge(age, rentalDays));
    System.out.println("Options Cost:" + optionsLogic(rentalDays, tollTag, gps, roadside));
  }

  private static double basicRental(int rentalDays) {
    return rentalDays * 29.99;
  }

  private static double underageSurcharge(int age, int rentalDays) {
    if (age < 25) {
      return (rentalDays * 29.99 * 0.30);
    } else {
      return 0;
    }
  }

  private static double optionsLogic(int rentalDays, boolean tollTag, boolean gps, boolean roadside) {
    if (tollTag == true && gps == true && roadside == true) {
      return rentalDays * 10.85;
    } else if (gps == true && tollTag == true || roadside == true) {
      return rentalDays * 6.90;
    } else if (tollTag == true && roadside == true) {
      return rentalDays * 7.90;
    } else if (tollTag == true || roadside == true) {
      return rentalDays * 3.95;
    } else if (gps == true) {
      return rentalDays * 2.95;
    } else {
      return 0;
    }
  }
}
