import abc
from typing import Tuple


# from main import Node


class NodeVisitor(abc.ABC):
    @abc.abstractmethod
    def visit(self, *inputs):
        pass


class ScalarSumVisitor(NodeVisitor):
    def visit(self, *inputs):
        return inputs[0].compute() + inputs[1].compute()


class BinaryOpVisitor(NodeVisitor):
    def __init__(self, operation):
        self.operation = operation

    def visit(self, *inputs):
        return self.operation(inputs[0].compute(), inputs[1].compute())
