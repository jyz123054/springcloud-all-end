package org.zmodule.service;

import org.zmodule.vo.Product;

public interface IMessageProvider {
    void send(Product product);
}
