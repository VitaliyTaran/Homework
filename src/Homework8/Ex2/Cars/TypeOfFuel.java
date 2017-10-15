package Homework8.Ex2.Cars;


public enum TypeOfFuel {
    BENZINE {
        public String getDescription() {
            return "Тип топлива: Бензин";
        }
    }, DIESEL {
        public String getDescription() {
            return "Тип топлива: Дизель";
        }
    }, GAS {
        public String getDescription() {
            return "Тип топлива: Газ";
        }
    }, ELECTRIC {
        public String getDescription() {
            return "Тип топлива: Электричество";
        }
    }
}
