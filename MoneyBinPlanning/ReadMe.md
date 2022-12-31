# Mortgage Planner

This is the mortgage planner program written for Money Bin inc. The program is
used for calculating the monthly payment over a fixed period of time
of possible prospects. For the calculation, the customer must input the total loan taken,
the yearly interest and what amount of years. The calculation is based on a mortgage formula
given below.

E = U[ b(1 + b)^p ] / [ (1 + b)^p - 1 ]



b = interest on a monthly basis,
U = total loan,
p = number of payments and,
E = fixed monthly payments,

****

## About the program

The program is written in Java. It uses Maven as a build tool. The program contains testing
for the mathematical logic. Junit is used for the testing. The program can be started from an IDE,
and the UI is terminal based.

****

## Classes

The program contains four classes.

The customer class holds information about the prospects and their loans,
such as name, total loan, amount of years, interest and monthly payment. To be able to
calculate the monthly payment it also holds a mortgage model object.

The file handler class is used for reading the information about the prospects from the given file,
and the responsible for creating customer objects. It will also create a list of the customers.

The mortgage model class is responsible for the calculations. It contains the needed information/attributes
for the mortgage formula. Some information from the customer class needs to be modified before
the method for calculating the mortgage formula can be used. Therefore, the constructor of the class
uses static methods for the needed modifications.

The main class is responsible for instantiating of the objects needed, and printing out the content from the
file and the calculations based on the objects made.

****

## Future improvements

This program only contains some information regarding the customers. I can imagine that
more information, such as if the possible customers are students or working could affect the loan.
This would be interesting to adapt into this program. For example, an interface containing
a method aimed for any specific necessary calculations. This interface could be implemented
by the customer or the mortgage class.

This program is terminal based. I have also made a webb interface in a different github
repository.