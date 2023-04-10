/*
package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.exception.FileException;
import itmo.p3108.util.AnalyzerExecuteScript;
import itmo.p3108.util.FileWorker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serial;
import java.nio.file.Files;
import java.nio.file.Path;

*/
/**
 * Command execute script.
 * Execute script. Has one argument (path) for script.
 * If fail doesn't exist or program can't read from -error occur
 *//*

@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ExecuteScript implements Command {
    @Serial
    private static final long serialVersionUID = 549988001L;
    private static final String ERROR_PERMISSION = "ExecuteScript error during setting path:can't read and write  file";
    private String path;

    */
/**
     * set path ,call before execute method
     *//*

    public void setPath(String path) {
        Path test = Path.of(path);
        if (!Files.isReadable(test) || !Files.isWritable(test)) {

            throw new FileException(ERROR_PERMISSION);
        }
        this.path = path;
    }

    @Override
    public String name() {
        return "execute_script";
    }


}
*/
