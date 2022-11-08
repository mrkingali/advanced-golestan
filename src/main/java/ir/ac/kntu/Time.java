package ir.ac.kntu;

public class Time {
    enum DayOfClass {
        SAT {
            @Override
            public String toString() {
                return "sat";
            }
        },
        SUN {
            @Override
            public String toString() {
                return "sun";
            }
        },
        MON {
            @Override
            public String toString() {
                return "mon";
            }
        },
        WEN {
            @Override
            public String toString() {
                return "wen";
            }
        },
        TUE {
            @Override
            public String toString() {
                return "tue";
            }
        }
    }

    enum HourOfClass {
        FROM_7_T_9 {
            @Override
            public String toString() {
                return "7to9";
            }
        },
        FROM_9_T_11 {
            @Override
            public String toString() {
                return "9to11";
            }
        },
        FROM_11_T_1 {
            @Override
            public String toString() {
                return "11to13";
            }
        },
        FROM_2_T_4 {
            @Override
            public String toString() {
                return "14to16";
            }
        },
        FROM_4_T_6 {
            @Override
            public String toString() {
                return "16to18";
            }
        },

    }
}
