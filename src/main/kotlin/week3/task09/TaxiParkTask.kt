package task09

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver>  =
    allDrivers - trips.map { it.driver }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    if (minTrips == 0) {
        allPassengers
    } else {
        trips.flatMap(Trip::passengers)
            .groupBy { passenger -> passenger }
            .filterValues { group -> group.size >= minTrips }
            .keys
    }

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> {
    return trips.filter { it.driver == driver }
        .flatMap(Trip::passengers)
        .groupBy { it }
        .filterValues { passengers -> passengers.size > 1 }
        .keys
}

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
    allPassengers.filter { p ->
        val tripsWithDiscount = trips.count { t -> p in t.passengers && t.discount != null }
        val tripsWithoutDiscount = trips.count { t -> p in t.passengers && t.discount == null }
        tripsWithDiscount > tripsWithoutDiscount
    }.toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there are no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? =
    trips.groupBy {
        val start = it.duration / 10 * 10
        val end = start + 9
        start..end
    }.maxBy { (_, group) -> group.size }?.key

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (trips.isEmpty()) {
        return false
    }

    val totalIncome = trips.sumByDouble(Trip::cost)
    val sortedIncomes = trips.groupBy(Trip::driver)
        .map { (_, tripsByDriver) -> tripsByDriver.sumByDouble(Trip::cost) }
        .sortedDescending()
    val numberOfTopDrivers = (0.2 * allDrivers.size).toInt()
    val incomeByTopDrivers = sortedIncomes.take(numberOfTopDrivers).sum()

    return incomeByTopDrivers >= 0.8 * totalIncome
}
