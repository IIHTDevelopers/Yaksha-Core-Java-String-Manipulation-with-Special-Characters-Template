package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;

public class AutoGrader {

    // Test for string manipulation with special characters
	public boolean testStringWithSpecialCharacters(String filePath) throws IOException {
        System.out.println("Starting testStringWithSpecialCharacters with file: " + filePath);

        // Load participant's file
        File participantFile = new File(filePath); // Path to participant's file
        if (!participantFile.exists()) {
            System.out.println("File does not exist at path: " + filePath);
            return false;
        }

        // Parse the file using JavaParser
        FileInputStream fileInputStream = new FileInputStream(participantFile);
        JavaParser javaParser = new JavaParser();
        CompilationUnit cu;
        try {
            cu = javaParser.parse(fileInputStream).getResult()
                    .orElseThrow(() -> new IOException("Failed to parse the Java file"));
        } catch (IOException e) {
            System.out.println("Error parsing the file: " + e.getMessage());
            throw e;
        }

        System.out.println("Parsed the Java file successfully.");

        // Flag to check for string manipulation with special characters
        boolean hasSpecialCharOperations = false;

        // 1. Checking if any special character-related methods (e.g., replaceAll, trim, matches) are used
        System.out.println("------ Checking String with Special Characters Operations ------");
        for (MethodCallExpr method : cu.findAll(MethodCallExpr.class)) {
            String methodName = method.getNameAsString();
            if (methodName.equals("replaceAll") || methodName.equals("trim") || methodName.equals("matches")) {
                hasSpecialCharOperations = true;
                System.out.println("✓ Found string manipulation with special characters method: " + methodName);
            }
        }

        // Output the result for string manipulation with special characters methods
        if (hasSpecialCharOperations) {
            System.out.println("✓ String manipulation with special characters methods are present.");
        } else {
            System.out.println("✘ Missing string manipulation with special characters methods.");
        }

        // Test result
        System.out.println("Test result: " + hasSpecialCharOperations);
        return hasSpecialCharOperations;
    }
}
