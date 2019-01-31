package oop.lab2;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import oop.lab2.CalculatorExceptions.ArgumentsExceptions.NotCommandException;
import oop.lab2.CalculatorExceptions.CalculatorException;
import oop.lab2.Operations.Operation;

import java.io.IOException;
import java.util.HashMap;

public final class OperationFactory {
    private static HashMap<String, String> mapOperations;

    private OperationFactory() {
    }

    private static void addBasic() {
        mapOperations.put("+", "oop.lab2.Operations.Add");
        mapOperations.put("-", "oop.lab2.Operations.Subtraction");
        mapOperations.put("DEFINE", "oop.lab2.Operations.Define");
        mapOperations.put("/", "oop.lab2.Operations.Division");
        mapOperations.put("*", "oop.lab2.Operations.Multiplication");
        mapOperations.put("POP", "oop.lab2.Operations.Pop");
        mapOperations.put("PUSH", "oop.lab2.Operations.Push");
        mapOperations.put("PRINT", "oop.lab2.Operations.Print");
        mapOperations.put("#", "oop.lab2.Operations.DoingNothing");
        mapOperations.put("SQRT", "oop.lab2.Operations.Sqrt");
    }

    public static int getInstance(String filePath) {
        if (mapOperations != null)
            return 0;   //TODO make exception
        mapOperations = new HashMap();
        mapOperations.putAll(FactoryLoader.makeMap(filePath));
        addBasic();
        return mapOperations.size();
    }

    public static boolean isOperation(String operation) {
        return mapOperations.containsKey(operation);
    }

    public static Operation findOperation(String operation) throws Exception {
        try {
            if (!OperationFactory.isOperation(operation)) {
                throw new NotCommandException(operation);
            }
        } catch (NotCommandException ex) {
            System.out.println(ex.what());
            throw new CalculatorException();
        }
        Class opClass = Class.forName(mapOperations.get(operation));
        Operation op = (Operation) opClass.newInstance();  //TODO exceptions if no such class
        return op;
    }

}
