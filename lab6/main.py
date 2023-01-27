from typing import List

import numpy as np

from NodeVisitor import NodeVisitor, ScalarSumVisitor, BinaryOpVisitor


class Node:
    def __init__(self, visitor: NodeVisitor, *inputs):
        self.visitor = visitor
        self.output = None
        self.inputs: List[Node] = list(inputs)
        print

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
    piemc = InputNode(5)
    cztei = InputNode(4)
    sumka = Node(BinaryOpVisitor(lambda a, b: a + b), piemc, cztei)
    print(sumka.compute())


if __name__ == "__main__":
    main()
