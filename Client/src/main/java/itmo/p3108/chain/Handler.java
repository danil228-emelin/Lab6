package itmo.p3108.chain;

import java.util.Optional;

public interface Handler<T> {
    Optional<T> processRequest(WrapperArgument wrapperArgument);


}
