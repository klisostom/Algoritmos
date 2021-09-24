<?php

declare(strict_types=1);

namespace App;

class Heap
{
    public function parent(int $i): float
    {
        return floor($i >> 1);
    }

    public function left(int $i): int
    {
        return ($i << 1) + 1;
    }

    public function right(int $i): int
    {
        return ($i << 1) + 2;
    }

    public function maxHeapify(array &$A, int &$index): void
    {
        $left = $this->left($index);
        $right = $this->right($index);
        $largest = null;

        if ($left < count($A) && $A[$left] > $A[$index]) {
            $largest = $left;
        } else {
            $largest = $index;
        }

        if ($right < count($A) && $A[$right] > $A[$largest]) {
            $largest = $right;
        }

        if ($largest != $index) {
            $temp = $A[$largest];
            $A[$largest] = $A[$index];
            $A[$index] = $temp;

            $this->maxHeapify($A, $largest);
        }
    }
}
