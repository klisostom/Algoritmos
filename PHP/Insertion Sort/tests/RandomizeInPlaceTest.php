<?php declare(strict_types=1);

namespace App;

use PHPUnit\Framework\TestCase;

define('__ROOT__', dirname(dirname(__FILE__)));

require_once __ROOT__ . '../vendor/autoload.php';

class RandomizeInPlaceTest extends TestCase
{
    public function setUp(): void
    {
        parent::setUp();
    }

    /** @test */
    public function randomInPlace(): void
    {
        # Arrange
        $arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
        $obj = new RandomizeInPlace();

        # Act
        $actual = $obj->permute($arr);

        # Assert
        $this->assertCount(
            count($arr),
            $actual,
            'Quantity of elements is not the same.'
        );
    }
}
