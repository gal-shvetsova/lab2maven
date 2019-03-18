package oop.lab2;

import oop.lab2.CalculatorExceptions.ArgumentsExceptions.NotCommandException;
import oop.lab2.Operations.Operation;

import org.apache.log4j.Logger;

import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class OperationFactory {
    private HashMap<String, String> mapOperations;

    private static OperationFactory instance = new OperationFactory();

    private OperationFactory() {
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

    public static OperationFactory init(String filePath) {
        if (instance.mapOperations == null){
            instance.mapOperations = new HashMap<>();
            instance.mapOperations.putAll(readOperations(filePath));
            return instance;
        }
        return instance;
    }

    static boolean isOperation(String operationKey) {
        return instance.mapOperations.containsKey(operationKey);
    }

    public Operation findOperation(String operationKey) throws Exception {
        try {
            if (!OperationFactory.isOperation(operationKey)) {
                throw new NotCommandException(operationKey);
            }
        } catch (NotCommandException ex) {
            System.out.println(ex);

            throw new NotCommandException("");
        }

        Class opClass = Class.forName(mapOperations.get(operationKey));
        return (Operation) opClass.newInstance();
    }

    public static int getMapOperationsSize() {
        return instance.mapOperations.size();
    }
}
