### 1) Berechnen Sie den Informationsgehalt des Wortes ELEKTROTECHNIKER

```
n = 16 Zeichen

p(E) = 4/16 = 1/4
p(K) = p(T) = p(R) = 2/16 = 1/8
p(L) = p(O) = p(C) = p(H) = p(N) = p(I) = 1/16

I(x) = -log2(p(x))

I(E) = 2 Bit
I(K) = I(T) = I(R) = 3 Bit
I(L) = I(O) = I(C) = I(H) = I(N) = I(I) = 4 Bit

Iges = 4*I(E) + 2*I(K) + 2*I(T) + 2*I(R) + I(L) + I(O) + I(C) + I(H) + I(N) + I(I)
     = 4*2Bit + 2*3Bit + 2*3Bit + 2*3Bit + 4Bit + 4Bit + 4Bit + 4Bit + 4Bit + 4Bit
     = 50 Bit 
```

### 2) Entwickeln Sie einen Huffman-Baum für das Wort ELEKTROTECHNIKER und geben Sie für jedes darin enthaltene Zeichen die codierte Bitfolge an.

```
                       (2)       (2)       (2)
                      /   \     /   \     /   \
E(4) K(2) T(2) R(2) L(1) O(1) C(1) H(1) N(1) I(1)
```

```
                                      (4)
                    (4)              /   \
                    / \             /     \
                   /   \           /       \
        (4)       /    (2)       (2)       (2)
       /   \     /    /   \     /   \     /   \
E(4) K(2) T(2) R(2) L(1) O(1) C(1) H(1) N(1) I(1)
```

```
                             (8)
                             /  \
                            /    \
                           /      \
                          /        \
                         /          \
                        /            \
                       /              \
                      /               (4)
     (8)            (4)              /   \
     / \            / \             /     \
    /   \          /   \           /       \
   /    (4)       /    (2)       (2)       (2)
  /    /   \     /    /   \     /   \     /   \
E(4) K(2) T(2) R(2) L(1) O(1) C(1) H(1) N(1) I(1)
```

```
                     (16)
                     /  \
                    /    \
                   /      \
                  /       1\
                 /          \
                /            \
               /             (8)
            0 /              /  \
             /              /    \
            /              /      \
           /             0/       1\
          /              /          \
         /              /            \
        /              /              \
       /              /               (4)
     (8)            (4)              /   \
     / \            / \            0/    1\
   0/  1\         0/  1\           /       \
   /    (4)       /    (2)       (2)       (2)
  /   0/  1\     /   0/  1\    0/  1\    0/  1\
E(4) K(2) T(2) R(2) L(1) O(1) C(1) H(1) N(1) I(1)
```

```
E: 00
K: 010
T: 011
R: 100
L: 1010
O: 1011
C: 1100
H: 1101
N: 1110
I: 1111
```