<?php

declare(strict_types=1);

namespace App;

class RandomizeInPlace
{
    public function permute(array $elements): array
    {
        $n = count($elements);

        for ($i=0; $i < $n; $i++) {
            $selected = $elements[$i];
            $keyRandomized = random_int($i, ($n - 1));

            $randomizedValue = $elements[$keyRandomized];

            $elements[$i] = $randomizedValue;
            $elements[$keyRandomized] = $selected;
        }

        return $elements;
    }
}
