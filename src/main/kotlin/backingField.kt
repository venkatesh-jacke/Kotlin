fun main() {

}

class Bank {
    private var _balance = 1000.0; // Private backing field for balance, storing the actual balance
    var bal: Double
        get() {
            return _balance; // Returns the current value of the private _balance field
        }
        set(value) {
            _balance = value;
        }
}

class Human {
    var age: Int = 23
        get() {
            return field;  // 'field' represents the backing field for 'age' and returns its current value
        }
        set(value) {
            field = value;
        }
}