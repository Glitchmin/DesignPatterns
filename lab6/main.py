from typing import List

import numpy as np

from NodeVisitor import NodeVisitor, MatrixMultiplicationVisitor


class Node:
    def __init__(self, visitor: NodeVisitor, *inputs):
        self.visitor = visitor
        self.output = None
        self.inputs: List[Node] = list(inputs)

    def compute(self):
        """accept analogue"""
        if self.output is None:
            self.output = self.visitor.visit(*self.inputs)

        return self.output


class InputNode(Node):
    def __init__(self, output):
        super().__init__(None)
        self.output = output


def main():
    print("hello")
    piemc = InputNode(np.matrix([[1, 1], [2, 2]]))
    cztei = InputNode(np.matrix([[1, 1], [3, 2]]))
    sumka = Node(MatrixMultiplicationVisitor(), piemc, cztei)
    print(sumka.compute())


if __name__ == "__main__":
    main()
