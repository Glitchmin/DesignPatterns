import abc
from typing import Tuple

# from main import Node
import numpy as np


class NodeVisitor(abc.ABC):
    @abc.abstractmethod
    def visit(self, *inputs):
        pass


class ScalarSumVisitor(NodeVisitor):
    def visit(self, *inputs):
        return inputs[0].compute() + inputs[1].compute()


class AddVisitor(NodeVisitor):

    def visit(self, *inputs):
        return inputs[0].compute() + inputs[1].compute()


class SubtractVisitor(NodeVisitor):

    def visit(self, *inputs):
        return inputs[0].compute() - inputs[1].compute()


class ScalarMultiplicationVisitor(NodeVisitor):

    def visit(self, *inputs):
        return inputs[0].compute() * inputs[1].compute()


class MatrixMultiplicationVisitor(NodeVisitor):

    def visit(self, *inputs):
        return inputs[0].compute() @ inputs[1].compute()


class InversionVisitor(NodeVisitor):
    def visit(self, *inputs):
        return np.linalg.inv(inputs[0])
