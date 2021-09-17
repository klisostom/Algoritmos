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
    public function parent_works(): void
    {
        # Arrange
        $i = random_int(1, 10);
        $floorValue = floor($i / 2);

        # Act
        $actual = new Heap();

        # Assert
        $this->assertIsFloat($actual->parent($i), 'This result is not a float number.');
        $this->assertEquals($floorValue, $actual->parent($i));
    }

    /** @test */
    public function left_works(): void
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
}
