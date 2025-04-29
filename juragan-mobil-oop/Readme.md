```wsd
@startuml juraganmobil
' Enum for Vehicle Type
enum VehicleType {
  SUV
  TAXI
  PRIVATE_JET
  BOAT
}

' Interface for data input
interface DataInput {
  +inputVehicle(): Vehicle
  +inputIncome(vehicle: Vehicle): Income
  +getAllVehicles(): List<Vehicle>
  +getAllIncomes(): List<Income>
}

' Interface for console output
interface ConsoleOutput {
  +displayVehicleDetails(vehicle: Vehicle): void
  +displayIncomeDetails(income: Income): void
  +displaySummary(summaryData: SummaryData): void
}

' Interface for Summary Data
interface SummaryData {
  +getTotalCarIncome(): Double
  +getTotalPlaneIncome(): Double
  +getTotalBoatIncome(): Double
  +getTotalTax(): Double
  +getTotalCarCount(): Integer
  +getTotalPlaneCount(): Integer
  +getTotalBoatCount(): Integer
  +getAllData(): List<Vehicle>
  +getSubTotalIncome(): Double
}

' Interface for Rentable Vehicles (now with unit)
interface Rentable {
  +calculateRentalRate(duration: Double, unit: String): Double
}

' Interface for Orderable Vehicles
interface Orderable {
  +calculateOrderRate(distance: Double): Double
}

' Abstract class for Vehicle
abstract class Vehicle {
  +licensePlate: String
  +year: Integer
  +price: Double
  +seatCount: Integer
  +vehicleType: VehicleType
  +calculateTax(): Double
}

' Subclasses of Vehicle with dynamic pricing attributes
class SUV extends Vehicle implements Rentable {
  +rentalRatePerDay: Double
  +calculateRentalRate(duration: Double, unit: String): Double
}
class Taxi extends Vehicle implements Orderable {
  +baseFare: Double
  +ratePerKilometer: Double
  +calculateOrderRate(distance: Double): Double
}
class PrivateJet extends Vehicle implements Rentable {
  +rentalRatePerHour: Double
  +calculateRentalRate(duration: Double, unit: String): Double
}
class Boat extends Vehicle implements Rentable {
  +rentalRatePerHour: Double
  +calculateRentalRate(duration: Double, unit: String): Double
}

' Class for Income
class Income {
  +transactionDate: Date
  +total: Double
}

' Subclasses of Income based on vehicle usage
class RentalIncome extends Income {
  +rentalDuration: Double
  +rentalUnit: String
  +rentalRateVehicle: Double
  +orderPerHour: Double
  +driverFee: Double
}

class OrderIncome extends Income {
  +distance: Double
  +baseFareVehicle: Double
  +ratePerKilometerVehicle: Double
}

' Relationships between Vehicle and Income
Vehicle "1" -- "*" Income : has >
SUV --|> Vehicle
Taxi --|> Vehicle
PrivateJet --|> Vehicle
Boat --|> Vehicle
RentalIncome --|> Income
OrderIncome --|> Income

' Relationships between Interfaces and Classes
SUV ..|> Rentable
Taxi ..|> Orderable
PrivateJet ..|> Rentable
Boat ..|> Rentable

' Class for calculating and holding summary data
class DataSummary implements SummaryData {
  +getTotalCarIncome(): Double
  +getTotalPlaneIncome(): Double
  +getTotalBoatIncome(): Double
  +getTotalTax(): Double
  +getTotalCarCount(): Integer
  +getTotalPlaneCount(): Integer
  +getTotalBoatCount(): Integer
  +getAllData(): List<Vehicle>
  +getSubTotalIncome(): Double
}

DataSummary ..|> SummaryData

' Class for inputting data from console (now hardcoded)
class ConsoleInput implements DataInput {
  +getAllVehicles(): List<Vehicle>
  +getAllIncomes(): List<Income>
  -vehicles: List<Vehicle>
  -incomes: List<Income>
}

ConsoleInput ..|> DataInput

' Class for outputting data to console
class ConsoleOutputter implements ConsoleOutput {
  +displayVehicleDetails(vehicle: Vehicle): void
  +displayIncomeDetails(income: Income): void
  +displaySummary(summaryData: SummaryData): void
  -dateFormat: SimpleDateFormat
}

ConsoleOutputter ..|> ConsoleOutput

' Main class to run the application
class Main {
  +dataInput: DataInput [static]
  +main(args: String[]): void [static]
}

Main --|> DataInput : uses >
Main --|> ConsoleOutput : uses >
Main --|> SummaryData : uses > ' Possibly through ConsoleOutputter
@enduml