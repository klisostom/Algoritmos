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
        return $i << 1;
    }
}
