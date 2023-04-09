package itmo.p3108.chain;

import itmo.p3108.util.WrapperArgument;

import java.util.Optional;

public interface Handler {
    Optional<?> processRequest(WrapperArgument wrapperArgument);


}
