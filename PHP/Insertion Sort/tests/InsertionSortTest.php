<?php

declare(strict_types=1);

namespace App;

use PHPUnit\Framework\TestCase;

define('__ROOT__', dirname(dirname(__FILE__)));

require_once __ROOT__ . '../vendor/autoload.php';

final class InsertionSortTest extends TestCase
{
    public function setUp(): void
    {
        parent::setUp();
    }

    /** @test */
    public function insertion(): void
    {
        # Arrange
        $insertion = new InsertionSort();
        $array = [];

        for ($i = 0; $i < random_int(5, 15); $i++) {
            $array[] = $i;
        }

        $obj = new RandomizeInPlace();
        $permutation = $obj->permute($array);

        # Act
        $actual = $insertion->sort($permutation);

        # Assert
        $this->assertNotEquals($array, $permutation);

        $this->assertEquals(
            $array,
            $actual,
            'The arrays would must be equals.'
        );
    }

    /** @test */
    public function insertionDesc(): void
    {
        # Arrange
        $insertion = new InsertionSort();
        $array = [];

        for ($i = random_int(5, 15); $i >= 0; $i--) {
            $array[] = $i;
        }

        $obj = new RandomizeInPlace();
        $permutation = $obj->permute($array);

        # Act
        $actual = $insertion->sortDesc($permutation);

        # Assert
        $this->assertEquals(
            $array,
            $actual,
            'The arrays dont are equals in desc way.'
        );
    }
}
