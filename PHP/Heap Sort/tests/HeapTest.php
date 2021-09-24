<?php

declare(strict_types=1);

namespace App;

use PHPUnit\Framework\TestCase;

define('__ROOT__', dirname(dirname(__FILE__)));

require_once __ROOT__ . '../vendor/autoload.php';

final class HeapTest extends TestCase
{
    public function setUp(): void
    {
        parent::setUp();
    }

    /** @test */
    public function must_return_float_calculated_by_parent(): void
    {
        # Arrange
        $i = random_int(1, 10);
        $floorValue = floor($i / 2);

        # Act
        $actual = new Heap;

        # Assert
        $this->assertIsFloat($actual->parent($i), 'This result is not a float number.');
        $this->assertEquals($floorValue, $actual->parent($i));
    }

    /** @test */
    public function must_return_integer_calculated_by_left(): void
    {
        # Arrange
        $i = random_int(1, 10);
        $expected = 2 * $i;

        # Act
        $actual = new Heap;

        # Assert
        $this->assertIsInt($actual->left($i), 'This result is not a integer number.');
        $this->assertEquals($expected, $actual->left($i));
    }

    /** @test */
    public function must_return_integer_calculated_by_right(): void
    {
        # Arrange
        $i = random_int(1, 10);
        $expected = (2 * $i) + 1;

        # Act
        $actual = new Heap;

        # Assert
        $this->assertIsInt($actual->right($i), 'This result is not a integer number.');
        $this->assertEquals($expected, $actual->right($i));
    }

    /** @test */
    public function max_heapify(): void
    {
        # Arrange
        $actual = [16, 4, 10, 14, 7, 9, 3, 2, 8, 1];
        $expected = [16, 14, 10, 8, 7, 9, 3, 2, 4, 1];
        $index = 1;

        # Act
        $result = new Heap;
        $result->maxHeapify($actual, $index);

        # Assert
        $this->assertEquals($expected, $actual);
    }
}
