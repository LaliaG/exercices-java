package org.example.entity;

public class Computer extends Product{
    private String processor;
    private String memory;
    private Computer(ComputerBuilder builder) {
        processor = builder.processor;
        memory = builder.memory;
    }
    public static class ComputerBuilder extends AbstractProductBuilder {
        private String processor;
        private String memory;
        public ComputerBuilder processor(String processor) {
            this.processor = processor;
            return this;
        }
        public ComputerBuilder memory(String memory) {
            this.memory = memory;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}
