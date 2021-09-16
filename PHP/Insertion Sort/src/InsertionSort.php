<?php

declare(strict_types=1);

namespace App;

use PHPUnit\Util\Exception;

class InsertionSort
{
    public function sort(array $elements): array
    {
        if (empty($elements)) {
            throw new Exception("Array is empty.", 1);
        }

        for ($j=1; $j < count($elements); $j++) {
            $value = $elements[$j];
            $i = $j - 1;

            while ($i >= 0 && $elements[$i] > $value) {
                $elements[$i + 1] = $elements[$i];
                $i = $i - 1;
            }

            $elements[$i + 1] = $value; // Here, '$i' is the same that '$i = $i - 1;' after out of while loop.
        }

        return $elements;
    }

    public function sortDesc(array $elements): array
    {
        if (empty($elements)) {
            throw new Exception("Array is empty.", 1);
        }

        for ($j = (count($elements) - 2); $j >= 0; $j--) {
            $value = $elements[$j];
            $i = $j + 1;

            while ($i <= (count($elements) - 1) && $elements[$i] > $value) {
                $elements[$i - 1] = $elements[$i];
                $i = $i + 1;
            }

            $elements[$i - 1] = $value;
        }

        return $elements;
    }
}
