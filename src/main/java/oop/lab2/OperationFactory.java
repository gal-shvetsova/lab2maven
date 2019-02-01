package oop.lab2;

import oop.lab2.CalculatorExceptions.ArgumentsExceptions.NotCommandException;
import oop.lab2.Operations.Operation;

import org.apache.log4j.Logger;

import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

final class OperationFactory {
    private static HashMap<String, String> mapOperations;

    private OperationFactory() {
    }

    private static void fillBasicOperations() {
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

    static Map readOperations(String filePath) {
        if (filePath == null) {
            return new HashMap();
        }
        Properties properties = new Properties();
        InputStream in = OperationFactory.class.getClassLoader().getResourceAsStream(filePath);
        try {
            properties.load(in);
            in.close();
        } catch (Exception ex) {
            Logger log = Logger.getLogger(OperationFactory.class);
            log.error("No file with operations");
        }
        return properties;
    }

    static void init(String filePath) {
        if (mapOperations == null || mapOperations.isEmpty()) {
            mapOperations = new HashMap<>();
            mapOperations.putAll(readOperations(filePath));

            fillBasicOperations();
        }
    }

    static boolean isOperation(String operationKey) {
        return mapOperations.containsKey(operationKey);
    }

    static Operation findOperation(String operationKey) throws Exception {
        try {
            if (!OperationFactory.isOperation(operationKey)) {
                throw new NotCommandException(operationKey);
            }
        } catch (NotCommandException ex) {
            System.out.println(ex.what());

            throw new NotCommandException("");
        }

        Class opClass = Class.forName(mapOperations.get(operationKey));
        return (Operation) opClass.newInstance();
    }

    static int getMapOperationsSize() {
        return mapOperations.size();
    }
}
