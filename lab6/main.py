from typing import List


from NodeVisitor import *


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
    s1 = InputNode(2)
    print("\n", s1.compute())
    s2 = InputNode(3)
    print("\n", s2.compute())
    s_sum = Node(ScalarSumVisitor(), s1, s2)
    print("\n", s_sum.compute())
    m1 = InputNode(np.matrix([[1, 1, 1], [2, 2, 2]]))
    print("\n", m1.compute())
    m1s = Node(ScalarMultiplicationVisitor(), m1, s_sum)
    print("\n", m1s.compute())
    m2 = InputNode(np.matrix([[1, 1], [3, 2], [6, 7]]))
    print("\n", m2.compute())
    m1sm2 = Node(MatrixMultiplicationVisitor(), m1s, m2)
    print("\n", m1sm2.compute())
    m1sm2t = Node(TransposeVisitor(), m1sm2)
    print("\n", m1sm2t.compute())


if __name__ == "__main__":
    main()
